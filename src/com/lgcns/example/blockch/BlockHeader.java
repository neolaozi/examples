package com.lgcns.example.blockch;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by hosang on 2017. 12. 2..
 */
public class BlockHeader {

	private int version; // Ignore for now.
	private byte[] previousBlockHash;
	private int merkleRootHash;
	private int timestamp; // Ignore for now.
	private int difficultyTarget; // Ignore for now.
	private int nonce; // Ignore for now.

	public BlockHeader(byte[] previousBlockHash, Object[] transactions) {
		this.previousBlockHash = previousBlockHash;
		this.merkleRootHash = this.someMethod(transactions);
	}

	public byte[] toByteArray() {
		String tmpStr = "";
		if (previousBlockHash != null) {
			tmpStr += new String(previousBlockHash, 0, previousBlockHash.length);
		}
		tmpStr += merkleRootHash;
		return tmpStr.getBytes(StandardCharsets.UTF_8);
	}

	private int someMethod(Object[] transations) {
		return Arrays.hashCode(transations);
	}
}