package in.example.fund;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface FundService {

	FundTranserResponse transfer(FundTransferRequest request) throws JsonProcessingException;

}
