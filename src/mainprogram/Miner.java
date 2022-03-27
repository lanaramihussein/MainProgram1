/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainprogram;





/**
 *
 * @author Flash Tech
 */
public class Miner extends BlockChain{
    
 
    private double reward;    
  
    public void mine(Block block, BlockChain blockChain) {  
  
        while(notGoldenHash(block)) {  
            //generating the block hash  
            block.generateHash();  
            block.incrementNonce();  
        }  
  
        System.out.println(block+" has just mined...");  
        System.out.println("Hash is: "+block.getHash());          
        //appending the block to the blockchain  
        blockChain.addBlock(block);  
        //calculating the reward  
        reward+=Costant.MINER_REWARD;  
  
    }  
      
    // So miners will generate hash values until they find the right hash.  
    //that matches with DIFFICULTY variable declared in class Constant   
    public boolean notGoldenHash(Block block) {  
  
        String leadingZeros = new String(new char[Costant.DIFFICULTY]).replace('\0', '0');  
  
        return !block.getHash().substring (0, Costant.DIFFICULTY).equals (leadingZeros);

    }  
    public double getReward() {  
        return this.reward;  
    }  
  
}