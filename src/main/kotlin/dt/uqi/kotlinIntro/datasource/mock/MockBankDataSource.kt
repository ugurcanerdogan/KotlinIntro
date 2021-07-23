package dt.uqi.kotlinIntro.datasource.mock

import dt.uqi.kotlinIntro.datasource.BankDataSource
import dt.uqi.kotlinIntro.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository("mock")
class MockBankDataSource : BankDataSource{

    val banks =  mutableListOf(
        Bank("Bank1",5.0,2),
        Bank("Bank2",15.0,4),
        Bank("Bank3",25.0,8)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.first { it.accountNumber == accountNumber }
    override fun createBank(bank: Bank): Bank {
        if(banks.any{it.accountNumber == bank.accountNumber}){
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists ")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull{ it.accountNumber == bank.accountNumber}
            ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull{ it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
        banks.remove(currentBank)
    }

}