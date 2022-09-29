package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.entity.Ads;

import java.util.Collection;

public interface AdsService {
    Ads createAds(Ads ads);

    Ads getFullAds(long id);

    Collection<Ads> gatAllAds();

    void removeAds(long id);

    Ads update(long id, Ads updatedAdsDto);
}

