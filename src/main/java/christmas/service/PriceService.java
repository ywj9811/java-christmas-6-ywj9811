package christmas.service;

public interface PriceService {
    int getTotalPriceBefore();

    int getTotalPriceAfter(int totalBenefit, int presentationBenefit);
}


