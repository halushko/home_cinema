package com.halushko.kinocat.file;

import com.halushko.kinocat.core.JsonConstants;
import com.halushko.kinocat.core.prcessors.ServicesInfoProcessor;
import com.halushko.kinocat.core.prcessors.ValueProcessor;

import java.util.ArrayList;
import java.util.List;

public class DevicesProcessor extends ServicesInfoProcessor {

    public DevicesProcessor(String json) {
        super(json);
    }

    @Override
    public ValueProcessor getNameProcessor() {
        return new ValueProcessor(JsonConstants.WebKeys.KEY_NAME, Constants.EMPTY_SERVICE_DEFAULT_NAME);
    }

    @Override
    public List<ValueProcessor> getServiceProcessors() {
        return new ArrayList<>() {{
            this.add(new ValueProcessor("folder", ""));
        }};
    }

    @Override
    public String getUrlTemplate() {
        return "";
    }
}
