package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.models.entities.Model;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepo;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepo) {
        this.modelRepo = modelRepo;
    }

    @Override
    public Model save(Model entity) {
        return this.modelRepo.save(entity);
    }
}
