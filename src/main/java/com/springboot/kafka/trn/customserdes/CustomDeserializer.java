package com.springboot.kafka.trn.customserdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.kafka.trn.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
@Slf4j
public class CustomDeserializer implements Deserializer<Employee> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Employee deserialize(String topic, byte[] data) {
        try {
            if(data == null) {
                log.info("Null received at deserializing");
                return null;
            }
            log.info("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), Employee.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
