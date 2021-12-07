package com.amazon.ata.hashingset.partsmanager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartManager {
    private Set<DevicePart> deviceParts = new HashSet<>();
    private final int numParts = 10;
    private List<DevicePart>[] parts = new ArrayList[numParts];

    public void addDevicePart(DevicePart devicePart) {
        boolean isAdded = deviceParts.add(devicePart);
        int partIndex = Math.abs(devicePart.hashCode()) % numParts;

        if (parts[partIndex] == null) {
            parts[partIndex] = new ArrayList<>();
        }
        parts[partIndex].add(devicePart);
    }

    public DevicePart findDevicePart(DevicePart devicePart) {
        DevicePart returnedObject = null;
        int partIndex = Math.abs(devicePart.hashCode()) % numParts;
        if (parts[partIndex] != null) {
            returnedObject = parts[partIndex].get(parts[partIndex].indexOf(devicePart));
        }
        return returnedObject;
    }

    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }
}
