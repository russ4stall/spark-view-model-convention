package com.russ4stall.spark;

import spark.ModelAndView;
import spark.ResponseTransformer;
import spark.TemplateEngine;

/**
 * Created by russellf on 2/25/2016.
 */
public class ViewModelTransformer implements ResponseTransformer {
    private final TemplateEngine templateEngine;
    private final String templateDirectory;
    private final String templateExtension;
    private final TemplateModel templateModel;

    public ViewModelTransformer(TemplateEngine templateEngine, String templateDirectory, String templateExtension, TemplateModel templateModel) {
        this.templateEngine = templateEngine;
        //TODO: check for preceding /, if doesn't exist -> add it
        //TODO: allow to be empty string
        this.templateDirectory = templateDirectory;
        //TODO: check for preceding period, if doesn't exist -> add it
        //TODO: make default .html... or something else
        this.templateExtension = templateExtension;
        this.templateModel = templateModel;
    }

    @Override
    public String render(Object model) throws Exception {
        String templateName = model.getClass().getSimpleName();
        if (templateName.endsWith("ViewModel")) {
            templateName = templateName.substring(0, templateName.length() - 9);
            templateName = templateName.toLowerCase();
            templateName = templateDirectory.concat(templateName);
            templateName = templateName.concat(templateExtension);
        } else {
            throw new IllegalArgumentException("argument must end with 'ViewModel'");
        }

        return templateEngine.render(new ModelAndView(templateModel.createModel(model), templateName));
    }
}
