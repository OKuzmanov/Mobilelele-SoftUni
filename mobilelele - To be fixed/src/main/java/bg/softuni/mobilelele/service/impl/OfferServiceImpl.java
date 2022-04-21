package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.models.entities.Offer;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepo;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepo) {
        this.offerRepo = offerRepo;
    }

    @Override
    public Offer save(Offer entity) {
        return this.offerRepo.save(entity);
    }
}
