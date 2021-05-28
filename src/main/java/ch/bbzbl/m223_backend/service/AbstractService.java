package ch.bbzbl.m223_backend.service;

import org.modelmapper.ModelMapper;

public abstract class AbstractService {

    private final ModelMapper mapper = new ModelMapper();

    protected <D> D map(Object source, Class<D> destination){
        return this.mapper.map(source, destination);
    }

    protected boolean validateId (String id){
        String regex = "\\d+";
        return id != null
                && !"".equals(id)
                && id.matches(regex);
    }
}
