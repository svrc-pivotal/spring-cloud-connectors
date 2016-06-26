package org.springframework.cloud.service.common;

import org.springframework.cloud.service.ServiceInfo;

@ServiceInfo.ServiceLabel("sqlserver")
public class SqlServerServiceInfo extends RelationalServiceInfo {
	public static final String SQLSERVER_SCHEME = "sqlserver";
	public static final String JTDS_SQLSERVER_SCHEME = "jtds:sqlserver";
	
	public SqlServerServiceInfo(String id, String url) {
		this(id, url, null);
	}

	public SqlServerServiceInfo(String id, String url, String jdbcUrl) {
		super(id, url, jdbcUrl, (jdbcUrl != null && jdbcUrl.contains("jtds")) ? JTDS_SQLSERVER_SCHEME : SQLSERVER_SCHEME);
	}

	@Override
	protected String buildJdbcUrl() {
		return String.format("jdbc:%s://%s:%d;database=%s;user=%s;password=%s",
				jdbcUrlDatabaseType,
				getHost(), getPort(), getPath(), getUserName(), getPassword());
	}
}
