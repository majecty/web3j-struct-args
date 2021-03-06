package io.borre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

  @Test
  public void testHi() {
    ArrayList<FlushData> flushData = new ArrayList<>();
    flushData.add(new FlushData(Address.DEFAULT, new Uint256(2),  Bytes32.DEFAULT));
    List<Type> inputParameters = Arrays.asList(
        new org.web3j.abi.datatypes.DynamicArray<FlushData>(
            FlushData.class,
            flushData
        )
    );
    List<TypeReference<?>> outParameters = Collections.emptyList();
    org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
        "flush",
        inputParameters,
        outParameters
    );
    String encoded = FunctionEncoder.encode(function);
    System.out.println(encoded);
    assertEquals("0x51acecc4", encoded.substring(0, 10));
    System.out.println("hi test");
  }

  public static class FlushData extends DynamicStruct {
    private Address token;
    private Uint256 version;
    private Bytes32 salt;

    public FlushData(FlushData flushData) {
      super(flushData.token, flushData.version, flushData.salt);
      this.token = flushData.token;
      this.version = flushData.version;
      this.salt = flushData.salt;
    }

    public FlushData(Address token, Uint256 version, Bytes32 salt) {
      super(token, version, salt);
      this.token = token;
      this.version = version;
      this.salt = salt;
    }
  }
}