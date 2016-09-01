package com.androidchill.nikiizvorski.gson.models;

import java.util.List;

/**
 * Created by nikiizvorski on 2/10/2016.
 */
public class ResponceRaces {

    /**
     * id : 1
     * mask : 1
     * side : alliance
     * name : Human
     */

    private List<RacesEntity> races;

    public void setRaces(List<RacesEntity> races) {
        this.races = races;
    }

    public List<RacesEntity> getRaces() {
        return races;
    }

    public static class RacesEntity {
        private int id;
        private int mask;
        private String side;
        private String name;

        public void setId(int id) {
            this.id = id;
        }

        public void setMask(int mask) {
            this.mask = mask;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public int getMask() {
            return mask;
        }

        public String getSide() {
            return side;
        }

        public String getName() {
            return name;
        }

        public String getImage(){
            if (getName().equals("Blood Elf")) {
                    return "http://eu.battle.net/wow/static/images/game/race/blood-elf/bg.jpg";
                } else if (getName().equals("Night Elf")){
                    return "http://eu.battle.net/wow/static/images/game/race/night-elf/bg.jpg";
                }
                return "http://eu.battle.net/wow/static/images/game/race/"+ getName().toLowerCase() +"/bg.jpg";
            }
    }
}
