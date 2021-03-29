package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {
    private List<Fish> fishes = new ArrayList<>();

    public List<String> getStatus() {
//        return fishes.stream()
//                .map(Fish::status)
//                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        for (Fish fish : fishes) {
            result.add(fish.status());
        }
        return result;
    }

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
//        fishes.stream()
//                .forEach(Fish::feed);

        for (Fish fish : fishes) {
            fish.feed();
        }
    }

    public void removeFish() {
//---------1.--------
//        fishes = fishes.stream()
//                .filter(f -> f.weight < 11)
//                .collect(Collectors.toList());

//---------2.--------
//        Iterator<Fish> iterator = fishes.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().weight>=11){
//                iterator.remove();
//            }
//        }

//---------3.--------
        fishes.removeIf(f -> f.weight >= 11);
    }


}
