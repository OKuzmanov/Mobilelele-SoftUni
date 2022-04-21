package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.models.entities.Brand;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepo;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepo) {
        this.brandRepo = brandRepo;
    }

    @Override
    public Brand save(Brand entity) {

        return this.brandRepo.save(entity);
    }
}
