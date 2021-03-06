package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;
import sg.com.ncs.brain.model.dataset.DatasetData;

@Entity
@Data
@NoArgsConstructor
@Table(name = "model_dataset_skeleton_fields", indexes = {
		@Index(name = "model_dataset_index", columnList = "table_id,column_name,status", unique = false) })
public class ModelDatasetSkeletonFields implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer table_id;
	@Column(nullable = false)
	private String column_name;
	@Column(nullable = false)
	private Integer fieldSeqNo;
	private String display_name;
	@Column(nullable = false)
	private String column_type;
	@Column(nullable = false)
	private String control_type;
	private String column_format;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean is_dynamic;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean is_mandatory;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean is_visible;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	@ManyToOne
	private ModelDatasetSkeletonTables modelDatasetSkeletonTables;

	@OneToMany(mappedBy = "modelDatasetSkeletonFields")
	private List<DatasetData> datasetData = new ArrayList<>();
}