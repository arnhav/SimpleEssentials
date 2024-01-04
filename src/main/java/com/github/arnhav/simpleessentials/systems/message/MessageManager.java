package com.github.arnhav.simpleessentials.systems.message;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class MessageManager {

    private Map<UUID, UUID> lastMessaged = new HashMap<>();

}
