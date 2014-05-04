package org.everit.osgi.thymeleaf.extender.internal;

import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.resourceresolver.UrlResourceResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.ITemplateResolutionValidity;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolution;

public class OSGiTemplateResolver implements ITemplateResolver {

    public static final String NAME = OSGiTemplateResolver.class.getName();

    private final IResourceResolver resourceResolver = new UrlResourceResolver();

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Integer getOrder() {
        return 1;
    }

    @Override
    public TemplateResolution resolveTemplate(TemplateProcessingParameters templateProcessingParameters) {

        String templateName = templateProcessingParameters.getTemplateName();
        String resourceName = "";
        // TODO Get character encoding from the capability
        String characterEncoding = "UTF8";
        // TODO Get the mode from the capability if specified
        String templateMode = StandardTemplateModeHandlers.XHTML.getTemplateModeName();
        ITemplateResolutionValidity validity = null;
        new TemplateResolution(templateName, resourceName, resourceResolver, characterEncoding, templateMode, validity);
        return null;
    }

    @Override
    public void initialize() {

    }

}
