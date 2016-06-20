package com.java8.designing;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtilRefactored {

    public static int totalAssetValues(final List<Asset> assets,
                                       final Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static void main(String[] args) {

        final ImmutableList<Asset> assets = ImmutableList.of(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );

        System.out.println("Total of all assets: " +
                totalAssetValues(assets, asset -> true));

        System.out.println("Total of bonds: " +
                totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.BOND));

        System.out.println("Total of stock: " +
                totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.STOCK));
    }
}
