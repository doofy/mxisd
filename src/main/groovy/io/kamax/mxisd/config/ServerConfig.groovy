/*
 * mxisd - Matrix Identity Server Daemon
 * Copyright (C) 2017 Maxime Dor
 *
 * https://max.kamax.io/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.mxisd.config

import org.apache.commons.lang.StringUtils
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "server")
class ServerConfig implements InitializingBean {

    private String name

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    @Override
    void afterPropertiesSet() throws Exception {
        if (StringUtils.isBlank(getName())) {
            throw new RuntimeException("Server name must be configured. Use the same realm as your Homeserver")
        }
    }

}
