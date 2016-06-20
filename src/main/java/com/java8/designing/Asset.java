package com.java8.designing;

public class Asset {

    public enum AssetType { BOND, STOCK };

    private final AssetType _type;
    private final int _value;

    public Asset(AssetType _type, int _value) {

        this._type = _type;
        this._value = _value;
    }

    public AssetType getType() {
        return _type;
    }

    public int getValue() {
        return _value;
    }
}
