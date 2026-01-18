package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum TaskPriority {
    LOW("Низкий"),
    NORMAL("Средний"),
    HIGH("Высокий"),
    SPECIAL("Специальный");

    private final String rusName;
}
