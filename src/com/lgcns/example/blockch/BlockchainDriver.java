package com.lgcns.example.blockch;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainDriver {

	List<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) throws NoSuchAlgorithmException {
		 
	    // Genesis block
	    String[] transactions = {"Hosang sent 1k Bitcoins to Zuckerberg."};
	    Block genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
	    System.out.println("Block Hash : " + genesisBlock.getBlockHash());
	 
	    // Second block
	    String[] secondTransactions = {"Zuckerberg sent 500 Bitcoins to Hosang."};
	    Block secondBlock = new Block(new BlockHeader(genesisBlock.getBlockHash().getBytes(), secondTransactions), secondTransactions);
	    System.out.println("Second Block Hash : " + secondBlock.getBlockHash());
	 
	    // Third block
	    String[] thirdTransactions = {"Hosang sent 500 Bitcoins to Moon."};
	    Block thirdBlock = new Block(new BlockHeader(secondBlock.getBlockHash().getBytes(), thirdTransactions), thirdTransactions);
	    System.out.println("Third Block Hash : " + thirdBlock.getBlockHash());
	 
	}
}
