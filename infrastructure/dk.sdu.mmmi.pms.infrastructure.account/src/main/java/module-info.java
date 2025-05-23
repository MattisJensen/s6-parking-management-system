import dk.sdu.mmmi.pms.application.shared.ModuleConfigurationSPI;
import dk.sdu.mmmi.pms.infrastructure.account.config.AccountConfigProvider;

module dk.sdu.mmmi.pms.infrastructure.account {
    // Internal dependencies
    requires dk.sdu.mmmi.pms.core.account;
    requires dk.sdu.mmmi.pms.application.account;
    requires dk.sdu.mmmi.pms.application.shared;

    // External dependencies
    requires spring.context;
    requires spring.data.jpa;
    requires spring.security.core;
    requires spring.tx;
    requires jakarta.persistence;

    // Visibility
    provides ModuleConfigurationSPI with AccountConfigProvider;
    opens dk.sdu.mmmi.pms.infrastructure.account to spring.beans, spring.context, spring.core, org.hibernate.orm.core;
    opens dk.sdu.mmmi.pms.infrastructure.account.authentication to spring.beans, spring.context, spring.core;
    opens dk.sdu.mmmi.pms.infrastructure.account.config to spring.beans, spring.context, spring.core;
    opens dk.sdu.mmmi.pms.infrastructure.account.persistence to spring.beans, spring.context, spring.core, org.hibernate.orm.core;
}