package com.zendesk.maxwell.producer;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class MaxwellOutputConfig {
	public enum Encryption {
		ENCRYPT_NONE,
		ENCRYPT_DATA,
		ENCRYPT_ALL
	}

	public boolean includesBinlogPosition;
	public boolean includesGtidPosition;
	public boolean includesCommitInfo;
	public boolean includesNulls;
	public boolean includesServerId;
	public boolean includesThreadId;
	public boolean outputDDL;
	public List<Pattern> excludeColumns;
	public Encryption encryptionMode;
	public String secretKey;

	public MaxwellOutputConfig() {
		this.includesBinlogPosition = false;
		this.includesGtidPosition = false;
		this.includesCommitInfo = true;
		this.includesNulls = true;
		this.includesServerId = false;
		this.includesThreadId = false;
		this.outputDDL = false;
		this.excludeColumns = new ArrayList<>();
		this.encryptionMode = Encryption.ENCRYPT_NONE;
		this.secretKey = null;
	}

	public boolean encryptionEnabled() {
		return encryptionMode != Encryption.ENCRYPT_NONE;
	}
}
