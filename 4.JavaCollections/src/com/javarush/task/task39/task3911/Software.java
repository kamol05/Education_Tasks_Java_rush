package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        List<Integer> list = new ArrayList<>();
        int version = rollbackVersion +1;
        if (versionHistoryMap.containsKey(rollbackVersion)){
            currentVersion = rollbackVersion;
            while(versionHistoryMap.containsKey(version)){
                versionHistoryMap.remove(version);
                version++;
            }
            return true;
            }
            return false;
        }
    }
