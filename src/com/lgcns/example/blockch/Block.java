package com.lgcns.example.blockch;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hosang on 2017. 12. 2..
 */
public class Block {

	private int blockSize; // Ignore for now.
	private BlockHeader blockHeader;
	private int transactionCount; // Ignore for now.
	private Object[] transactions;

	public Block(BlockHeader blockHeader, Object[] transactions) {
		this.blockHeader = blockHeader;
		this.transactions = transactions;
	}

	public String getBlockHash() throws NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

		// Hash twice - Not a K-pop girl group.
		byte[] blockHash = messageDigest.digest(blockHeader.toByteArray());
		blockHash = messageDigest.digest(blockHash);

		return new String(blockHash, 0, blockHash.length);
	}

}