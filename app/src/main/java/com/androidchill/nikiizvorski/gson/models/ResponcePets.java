package com.androidchill.nikiizvorski.gson.models;

import java.util.List;

/**
 * Created by NIKI on 7/18/2016.
 */
public class ResponcePets {

    /**
     * canBattle : true
     * creatureId : 45128
     * name : Crawling Claw
     * family : undead
     * icon : inv_offhand_stratholme_a_02
     * qualityId : 4
     * stats : {"speciesId":264,"breedId":3,"petQualityId":1,"level":1,"health":150,"power":10,"speed":8}
     * strongAgainst : ["humanoid"]
     * typeId : 3
     * weakAgainst : ["water"]
     */

    private List<PetsBean> pets;

    public List<PetsBean> getPets() {
        return pets;
    }

    public void setPets(List<PetsBean> pets) {
        this.pets = pets;
    }

    public static class PetsBean {
        private boolean canBattle;
        private int creatureId;
        private String name;
        private String family;
        private String icon;
        private int qualityId;
        /**
         * speciesId : 264
         * breedId : 3
         * petQualityId : 1
         * level : 1
         * health : 150
         * power : 10
         * speed : 8
         */

        private StatsBean stats;
        private int typeId;
        private List<String> strongAgainst;
        private List<String> weakAgainst;

        public boolean isCanBattle() {
            return canBattle;
        }

        public void setCanBattle(boolean canBattle) {
            this.canBattle = canBattle;
        }

        public int getCreatureId() {
            return creatureId;
        }

        public void setCreatureId(int creatureId) {
            this.creatureId = creatureId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getQualityId() {
            return qualityId;
        }

        public void setQualityId(int qualityId) {
            this.qualityId = qualityId;
        }

        public StatsBean getStats() {
            return stats;
        }

        public void setStats(StatsBean stats) {
            this.stats = stats;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public List<String> getStrongAgainst() {
            return strongAgainst;
        }

        public void setStrongAgainst(List<String> strongAgainst) {
            this.strongAgainst = strongAgainst;
        }

        public List<String> getWeakAgainst() {
            return weakAgainst;
        }

        public void setWeakAgainst(List<String> weakAgainst) {
            this.weakAgainst = weakAgainst;
        }

        public static class StatsBean {
            private int speciesId;
            private int breedId;
            private int petQualityId;
            private int level;
            private int health;
            private int power;
            private int speed;

            public int getSpeciesId() {
                return speciesId;
            }

            public void setSpeciesId(int speciesId) {
                this.speciesId = speciesId;
            }

            public int getBreedId() {
                return breedId;
            }

            public void setBreedId(int breedId) {
                this.breedId = breedId;
            }

            public int getPetQualityId() {
                return petQualityId;
            }

            public void setPetQualityId(int petQualityId) {
                this.petQualityId = petQualityId;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getHealth() {
                return health;
            }

            public void setHealth(int health) {
                this.health = health;
            }

            public int getPower() {
                return power;
            }

            public void setPower(int power) {
                this.power = power;
            }

            public int getSpeed() {
                return speed;
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }
        }
    }
}
