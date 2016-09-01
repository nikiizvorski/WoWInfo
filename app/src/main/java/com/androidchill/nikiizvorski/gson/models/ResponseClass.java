package com.androidchill.nikiizvorski.gson.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nikiizvorski on 1/31/2016.
 */
public class ResponseClass {

    /**
     * lastModified : 1453797395000
     * name : Dealerz
     * realm : Auchindoun
     * battlegroup : Vindication
     * class : 4
     * race : 22
     * gender : 0
     * level : 100
     * achievementPoints : 1850
     * thumbnail : auchindoun/120/148548728-avatar.jpg
     * calcClass : c
     * faction : 0
     * totalHonorableKills : 368
     */

    private long lastModified;
    private String name;
    private String realm;
    private String battlegroup;
    @SerializedName("class")
    private int classX;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;
    private String calcClass;
    private int faction;
    private int totalHonorableKills;

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public void setClassX(int classX) {
        this.classX = classX;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setCalcClass(String calcClass) {
        this.calcClass = calcClass;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public void setTotalHonorableKills(int totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    public long getLastModified() {
        return lastModified;
    }

    public String getName() {
        return name;
    }

    public String getRealm() {
        return realm;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public int getClassX() {
        return classX;
    }

    public int getRace() {
        return race;
    }

    public int getGender() {
        return gender;
    }

    public int getLevel() {
        return level;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getThumbnailImg () {
        return "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + getThumbnail();
    }

    public String getCharacterImage () {
        String urka = "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + getThumbnail();
        String porka = urka.replace("-avatar.jpg", "-profilemain.jpg");
        return porka;
    }

    public String getCalcClass() {
        return calcClass;
    }

    public int getFaction() {
        return faction;
    }

    public int getTotalHonorableKills() {
        return totalHonorableKills;
    }
}
