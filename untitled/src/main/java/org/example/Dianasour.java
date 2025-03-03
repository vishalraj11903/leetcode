package org.example;

import java.util.*;

public class Dianasour {
    static class Record {
        String type;
        double length;
        String foodType;
        public Record(String type, double length, String foodType) {
            this.type = type;
            this.length = length;
            this.foodType = foodType;
        }
    }

    public static void main(String... args) {
        List<Record> dataset2 = new ArrayList<>();
        dataset2.add(new Record("Euoplocephalus", 1.97, "quadrupedal"));
        dataset2.add(new Record("Stegosaurus", 1.7, "quadrupedal"));
        dataset2.add(new Record("Tyrannosaurus", 4.76, "bipedal"));
        dataset2.add(new Record("Hadrosaurus", 1.3, "bipedal"));
        dataset2.add(new Record("Deinonychus", 1.11, "bipedal"));
        dataset2.add(new Record("Struthiomimus", 1.24, "bipedal"));
        dataset2.add(new Record("Velociraptorr", 2.62, "bipedal"));

        List<Record> dataset1 = new ArrayList<>();
        dataset1.add(new Record("Hadrosaurus", 1.4, "herbivore"));
        dataset1.add(new Record("Struthiomimus", 0.72, "omnivore"));
        dataset1.add(new Record("Velociraptor", 1.8, "carnivore"));
        dataset1.add(new Record("Triceratops", 0.47, "herbivore"));
        dataset1.add(new Record("Euoplocephalus", 2.6, "herbivore"));
        dataset1.add(new Record("Stegosaurus", 1.5, "herbivore"));
        dataset1.add(new Record("Tyrannosaurus", 6.5, "carnivore"));

        Map<String, Double> map2 = new HashMap<>();
        for (Record r : dataset2) {
            if ("bipedal".equals(r.foodType)) {
                map2.put(r.type, r.length);
            }
        }

        Map<String, Double> map1 = new HashMap<>();
        for (Record r : dataset1) {
            map1.put(r.type, r.length);
        }

        TreeMap<Double, String> treeMap = new TreeMap<>();
        for (Map.Entry<String, Double> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
                double record = map1.get(entry.getKey());
                double speed = ((entry.getValue() / record) - 1) * Math.sqrt(record * 9.8);
                treeMap.put(speed, entry.getKey());
            }

        }

        for (Map.Entry<Double, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue() + "->" + entry.getKey());
        }

    }
}
