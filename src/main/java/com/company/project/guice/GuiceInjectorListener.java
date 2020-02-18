package com.company.project.guice;

import com.company.project.service.MicroserviceModule;
import com.company.project.service.StorageModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.ctoolkit.services.endpoints.EndpointsMonitorConfig;
import org.ctoolkit.services.guice.AppEngineEnvironmentContextListener;

/**
 * The main entry point to configure guice injection.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class GuiceInjectorListener
        extends AppEngineEnvironmentContextListener
{
    @Override
    protected Injector getDevelopmentInjector()
    {
        return Guice.createInjector( new MicroserviceModule(),
                new StorageModule(),
                new EndpointsInitialization() );
    }

    @Override
    protected Injector getProductionInjector()
    {
        return Guice.createInjector( new MicroserviceModule(),
                new StorageModule(),
                new EndpointsInitialization(),
                new EndpointsMonitorConfig() );
    }
}
