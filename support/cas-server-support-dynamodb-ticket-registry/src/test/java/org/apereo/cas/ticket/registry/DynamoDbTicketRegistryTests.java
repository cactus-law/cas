package org.apereo.cas.ticket.registry;

import org.apereo.cas.config.CasCoreAuthenticationConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationHandlersConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationMetadataConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationPolicyConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationPrincipalConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationSupportConfiguration;
import org.apereo.cas.config.CasCoreConfiguration;
import org.apereo.cas.config.CasCoreHttpConfiguration;
import org.apereo.cas.config.CasCoreServicesConfiguration;
import org.apereo.cas.config.CasCoreTicketCatalogConfiguration;
import org.apereo.cas.config.CasCoreTicketsConfiguration;
import org.apereo.cas.config.CasPersonDirectoryConfiguration;
import org.apereo.cas.config.DynamoDbTicketRegistryConfiguration;
import org.apereo.cas.config.DynamoDbTicketRegistryTicketCatalogConfiguration;
import org.apereo.cas.logout.config.CasCoreLogoutConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is {@link DynamoDbTicketRegistryTests}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DynamoDbTicketRegistryConfiguration.class,
        DynamoDbTicketRegistryTicketCatalogConfiguration.class,
        CasCoreTicketsConfiguration.class,
        CasCoreTicketCatalogConfiguration.class,
        CasCoreLogoutConfiguration.class,
        CasCoreHttpConfiguration.class,
        CasCoreServicesConfiguration.class,
        CasCoreAuthenticationConfiguration.class,
        CasCoreConfiguration.class,
        CasCoreAuthenticationHandlersConfiguration.class,
        CasCoreAuthenticationMetadataConfiguration.class,
        CasCoreAuthenticationPolicyConfiguration.class,
        CasCoreAuthenticationPrincipalConfiguration.class,
        CasCoreAuthenticationSupportConfiguration.class,
        CasPersonDirectoryConfiguration.class,
        RefreshAutoConfiguration.class})
@TestPropertySource(properties = {"cas.ticket.registry.dynamoDb.endpoint=http://localhost:8000",
        "cas.ticket.registry.dynamoDb.credentialAccessKey=AKIAIPPIGGUNIO74C63Q",
        "cas.ticket.registry.dynamoDb.credentialSecretKey=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"})
public class DynamoDbTicketRegistryTests extends AbstractTicketRegistryTests {

    @Autowired
    @Qualifier("ticketRegistry")
    private TicketRegistry ticketRegistry;

    @Override
    public TicketRegistry getNewTicketRegistry() throws Exception {
        return ticketRegistry;
    }
}
