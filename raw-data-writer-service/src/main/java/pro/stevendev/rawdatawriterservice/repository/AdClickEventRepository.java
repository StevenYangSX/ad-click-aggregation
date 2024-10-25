package pro.stevendev.rawdatawriterservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import pro.stevendev.rawdatawriterservice.model.AdClickEventModel;

public interface AdClickEventRepository extends CassandraRepository<AdClickEventModel, String> {
}
