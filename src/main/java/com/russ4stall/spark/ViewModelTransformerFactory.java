package com.russ4stall.spark;

import spark.TemplateEngine;

/**
 * Created by russellf on 2/25/2016.
 */
public class ViewModelTransformerFactory {
	private final TemplateEngine templateEngine;
    private final String templateDirectory;
    private final String templateExtension;
    private final TemplateModel templateModel;

    public ViewModelTransformerFactory(TemplateEngine templateEngine, String templateDirectory, String templateExtension, TemplateModel templateModel) {
        this.templateEngine = templateEngine;
        this.templateDirectory = templateDirectory;
        this.templateExtension = templateExtension;
        this.templateModel = templateModel;
    }

    public ViewModelTransformer getViewModelTransformer() {
        return new ViewModelTransformer(templateEngine, templateDirectory, templateExtension, templateModel);
    }
}
