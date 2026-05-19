from __future__ import annotations


class TTSEngine:
    def __init__(self, enabled: bool = True, rate: int = 170, volume: float = 1.0):
        self.enabled = enabled
        self.available = False
        self.engine = None
        self.error_message = ""
        if not enabled:
            return
        try:
            import pyttsx3

            self.engine = pyttsx3.init()
            self._configure(rate=rate, volume=volume)
            self.available = True
        except Exception as exc:
            self.available = False
            self.error_message = str(exc)

    def _configure(self, rate: int, volume: float) -> None:
        if self.engine is None:
            return
        try:
            self.engine.setProperty("rate", rate)
        except Exception:
            pass
        try:
            self.engine.setProperty("volume", max(0.0, min(1.0, volume)))
        except Exception:
            pass
        self._select_preferred_voice()

    def _select_preferred_voice(self) -> None:
        if self.engine is None:
            return
        try:
            voices = self.engine.getProperty("voices") or []
        except Exception:
            voices = []

        preferred_markers = [
            "spanish",
            "es_",
            "es-",
            "mex",
            "sabina",
            "helena",
            "zira",
            "dalia",
        ]

        for voice in voices:
            bag = " ".join(
                str(part).lower()
                for part in [
                    getattr(voice, "id", ""),
                    getattr(voice, "name", ""),
                    getattr(voice, "languages", ""),
                ]
            )
            if any(marker in bag for marker in preferred_markers):
                try:
                    self.engine.setProperty("voice", voice.id)
                    return
                except Exception:
                    continue

    def speak(self, text: str) -> bool:
        if not self.enabled:
            print("[TTS desactivado]", text)
            return False
        if self.available and self.engine is not None:
            try:
                self.engine.say(text)
                self.engine.runAndWait()
                return True
            except Exception as exc:
                print(f"[TTS] Error al reproducir voz: {exc}")
                return False

        print("[TTS no disponible en este equipo]")
        print("Instala la dependencia con: pip install -r requirements.txt")
        if self.error_message:
            print(f"Detalle técnico: {self.error_message}")
        return False
