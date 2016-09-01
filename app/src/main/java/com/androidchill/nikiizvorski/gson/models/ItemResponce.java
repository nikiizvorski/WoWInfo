package com.androidchill.nikiizvorski.gson.models;

import java.util.List;

/**
 * Created by nikiizvorski on 2/10/2016.
 */
public class ItemResponce {

    /**
     * id : 49284
     * description : Teaches you how to summon this mount.
     * name : Reins of the Swift Spectral Tiger
     * icon : ability_mount_spectraltiger
     * stackable : 1
     * itemBind : 0
     * bonusStats : []
     * itemSpells : [{"spellId":55884,"spell":{"id":55884,"name":"Learning","icon":"trade_engineering","description":"","castTime":"Instant"},"nCharges":1,"consumable":true,"categoryId":330,"trigger":"ON_USE"},{"spellId":42777,"spell":{"id":42777,"name":"Swift Spectral Tiger","icon":"ability_mount_spectraltiger","description":"Summons and dismisses a rideable Swift Spectral Tiger.","castTime":"1.5 sec cast"},"nCharges":0,"consumable":false,"categoryId":0,"trigger":"ON_LEARN"}]
     * buyPrice : 100000
     * itemClass : 15
     * itemSubClass : 5
     * containerSlots : 0
     * inventoryType : 0
     * equippable : false
     * itemLevel : 40
     * maxCount : 1
     * maxDurability : 0
     * minFactionId : 0
     * minReputation : 0
     * quality : 4
     * sellPrice : 0
     * requiredSkill : 0
     * requiredAbility : {"spellId":33391,"name":"Journeyman Riding","description":"You can now learn to ride fast ground mounts from your riding trainer."}
     * requiredLevel : 40
     * requiredSkillRank : 0
     * itemSource : {"sourceId":0,"sourceType":"PROMOTION"}
     * baseArmor : 0
     * hasSockets : false
     * isAuctionable : true
     * armor : 0
     * displayInfoId : 0
     * nameDescription :
     * nameDescriptionColor : 000000
     * upgradable : true
     * heroicTooltip : false
     * context :
     * bonusLists : []
     * availableContexts : [""]
     * bonusSummary : {"defaultBonusLists":[],"chanceBonusLists":[],"bonusChances":[]}
     */

    private int id;
    private String description;
    private String name;
    private String icon;
    private int stackable;
    private int itemBind;
    private int buyPrice;
    private int itemClass;
    private int itemSubClass;
    private int containerSlots;
    private int inventoryType;
    private boolean equippable;
    private int itemLevel;
    private int maxCount;
    private int maxDurability;
    private int minFactionId;
    private int minReputation;
    private int quality;
    private int sellPrice;
    private int requiredSkill;
    /**
     * spellId : 33391
     * name : Journeyman Riding
     * description : You can now learn to ride fast ground mounts from your riding trainer.
     */

    private RequiredAbilityEntity requiredAbility;
    private int requiredLevel;
    private int requiredSkillRank;
    /**
     * sourceId : 0
     * sourceType : PROMOTION
     */

    private ItemSourceEntity itemSource;
    private int baseArmor;
    private boolean hasSockets;
    private boolean isAuctionable;
    private int armor;
    private int displayInfoId;
    private String nameDescription;
    private String nameDescriptionColor;
    private boolean upgradable;
    private boolean heroicTooltip;
    private String context;
    private BonusSummaryEntity bonusSummary;
    private List<?> bonusStats;
    /**
     * spellId : 55884
     * spell : {"id":55884,"name":"Learning","icon":"trade_engineering","description":"","castTime":"Instant"}
     * nCharges : 1
     * consumable : true
     * categoryId : 330
     * trigger : ON_USE
     */

    private List<ItemSpellsEntity> itemSpells;
    private List<?> bonusLists;
    private List<String> availableContexts;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setStackable(int stackable) {
        this.stackable = stackable;
    }

    public void setItemBind(int itemBind) {
        this.itemBind = itemBind;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setItemClass(int itemClass) {
        this.itemClass = itemClass;
    }

    public void setItemSubClass(int itemSubClass) {
        this.itemSubClass = itemSubClass;
    }

    public void setContainerSlots(int containerSlots) {
        this.containerSlots = containerSlots;
    }

    public void setInventoryType(int inventoryType) {
        this.inventoryType = inventoryType;
    }

    public void setEquippable(boolean equippable) {
        this.equippable = equippable;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public void setMinFactionId(int minFactionId) {
        this.minFactionId = minFactionId;
    }

    public void setMinReputation(int minReputation) {
        this.minReputation = minReputation;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setRequiredSkill(int requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public void setRequiredAbility(RequiredAbilityEntity requiredAbility) {
        this.requiredAbility = requiredAbility;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public void setRequiredSkillRank(int requiredSkillRank) {
        this.requiredSkillRank = requiredSkillRank;
    }

    public void setItemSource(ItemSourceEntity itemSource) {
        this.itemSource = itemSource;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public void setHasSockets(boolean hasSockets) {
        this.hasSockets = hasSockets;
    }

    public void setIsAuctionable(boolean isAuctionable) {
        this.isAuctionable = isAuctionable;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    public void setNameDescriptionColor(String nameDescriptionColor) {
        this.nameDescriptionColor = nameDescriptionColor;
    }

    public void setUpgradable(boolean upgradable) {
        this.upgradable = upgradable;
    }

    public void setHeroicTooltip(boolean heroicTooltip) {
        this.heroicTooltip = heroicTooltip;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setBonusSummary(BonusSummaryEntity bonusSummary) {
        this.bonusSummary = bonusSummary;
    }

    public void setBonusStats(List<?> bonusStats) {
        this.bonusStats = bonusStats;
    }

    public void setItemSpells(List<ItemSpellsEntity> itemSpells) {
        this.itemSpells = itemSpells;
    }

    public void setBonusLists(List<?> bonusLists) {
        this.bonusLists = bonusLists;
    }

    public void setAvailableContexts(List<String> availableContexts) {
        this.availableContexts = availableContexts;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public int getStackable() {
        return stackable;
    }

    public int getItemBind() {
        return itemBind;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getItemClass() {
        return itemClass;
    }

    public int getItemSubClass() {
        return itemSubClass;
    }

    public int getContainerSlots() {
        return containerSlots;
    }

    public int getInventoryType() {
        return inventoryType;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public int getMinFactionId() {
        return minFactionId;
    }

    public int getMinReputation() {
        return minReputation;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getRequiredSkill() {
        return requiredSkill;
    }

    public RequiredAbilityEntity getRequiredAbility() {
        return requiredAbility;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getRequiredSkillRank() {
        return requiredSkillRank;
    }

    public ItemSourceEntity getItemSource() {
        return itemSource;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public boolean isHasSockets() {
        return hasSockets;
    }

    public boolean isIsAuctionable() {
        return isAuctionable;
    }

    public int getArmor() {
        return armor;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public String getNameDescriptionColor() {
        return nameDescriptionColor;
    }

    public boolean isUpgradable() {
        return upgradable;
    }

    public boolean isHeroicTooltip() {
        return heroicTooltip;
    }

    public String getContext() {
        return context;
    }

    public BonusSummaryEntity getBonusSummary() {
        return bonusSummary;
    }

    public List<?> getBonusStats() {
        return bonusStats;
    }

    public List<ItemSpellsEntity> getItemSpells() {
        return itemSpells;
    }

    public List<?> getBonusLists() {
        return bonusLists;
    }

    public List<String> getAvailableContexts() {
        return availableContexts;
    }

    public static class RequiredAbilityEntity {
        private int spellId;
        private String name;
        private String description;

        public void setSpellId(int spellId) {
            this.spellId = spellId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSpellId() {
            return spellId;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class ItemSourceEntity {
        private int sourceId;
        private String sourceType;

        public void setSourceId(int sourceId) {
            this.sourceId = sourceId;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public int getSourceId() {
            return sourceId;
        }

        public String getSourceType() {
            return sourceType;
        }
    }

    public static class BonusSummaryEntity {
        private List<?> defaultBonusLists;
        private List<?> chanceBonusLists;
        private List<?> bonusChances;

        public void setDefaultBonusLists(List<?> defaultBonusLists) {
            this.defaultBonusLists = defaultBonusLists;
        }

        public void setChanceBonusLists(List<?> chanceBonusLists) {
            this.chanceBonusLists = chanceBonusLists;
        }

        public void setBonusChances(List<?> bonusChances) {
            this.bonusChances = bonusChances;
        }

        public List<?> getDefaultBonusLists() {
            return defaultBonusLists;
        }

        public List<?> getChanceBonusLists() {
            return chanceBonusLists;
        }

        public List<?> getBonusChances() {
            return bonusChances;
        }
    }

    public static class ItemSpellsEntity {
        private int spellId;
        /**
         * id : 55884
         * name : Learning
         * icon : trade_engineering
         * description :
         * castTime : Instant
         */

        private SpellEntity spell;
        private int nCharges;
        private boolean consumable;
        private int categoryId;
        private String trigger;

        public void setSpellId(int spellId) {
            this.spellId = spellId;
        }

        public void setSpell(SpellEntity spell) {
            this.spell = spell;
        }

        public void setNCharges(int nCharges) {
            this.nCharges = nCharges;
        }

        public void setConsumable(boolean consumable) {
            this.consumable = consumable;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public void setTrigger(String trigger) {
            this.trigger = trigger;
        }

        public int getSpellId() {
            return spellId;
        }

        public SpellEntity getSpell() {
            return spell;
        }

        public int getNCharges() {
            return nCharges;
        }

        public boolean isConsumable() {
            return consumable;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public String getTrigger() {
            return trigger;
        }

        public static class SpellEntity {
            private int id;
            private String name;
            private String icon;
            private String description;
            private String castTime;

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setCastTime(String castTime) {
                this.castTime = castTime;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getIcon() {
                return icon;
            }

            public String getDescription() {
                return description;
            }

            public String getCastTime() {
                return castTime;
            }
        }
    }
}
