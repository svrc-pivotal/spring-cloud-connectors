package org.springframework.cloud.cloudfoundry;

import org.springframework.cloud.service.common.SqlServerServiceInfo;

public class SqlServerServiceInfoCreator extends RelationalServiceInfoCreator<SqlServerServiceInfo> {

	public SqlServerServiceInfoCreator() {
		super(new Tags(), SqlServerServiceInfo.SQLSERVER_SCHEME, SqlServerServiceInfo.JTDS_SQLSERVER_SCHEME);
	}

	@Override
	public SqlServerServiceInfo createServiceInfo(String id, String url, String jdbcUrl) {
		return new SqlServerServiceInfo(id, url, jdbcUrl);
	}
}
