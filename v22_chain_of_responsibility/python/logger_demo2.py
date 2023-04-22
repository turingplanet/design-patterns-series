from abc import ABC, abstractmethod


class Logger(ABC):

    def __init__(self, level):
        self.level = level
        self.next_logger = None

    def set_next_logger(self, next_logger):
        self.next_logger = next_logger

    def log_message(self, log_level, message):
        if log_level <= self.level:
            self.write(message)
        elif self.next_logger is not None:
            self.next_logger.log_message(log_level, message)

    @abstractmethod
    def write(self, message):
        pass


class ErrorLogger(Logger):
    def __init__(self, level):
        super().__init__(level)

    def write(self, message):
        print("Error: " + message)


class DebugLogger(Logger):
    def __init__(self, level):
        super().__init__(level)

    def write(self, message):
        print("Debug: " + message)


class InfoLogger(Logger):
    def __init__(self, level):
        super().__init__(level)

    def write(self, message):
        print("Info: " + message)


if __name__ == "__main__":
    error_logger = ErrorLogger(1)
    debug_logger = DebugLogger(2)
    info_logger = InfoLogger(3)

    error_logger.set_next_logger(debug_logger)
    debug_logger.set_next_logger(info_logger)

    error_logger.log_message(1, "This is an error message")
    error_logger.log_message(2, "This is a debug message")
    error_logger.log_message(3, "This is an info message")


