package io.openems.edge.battery.soltaro.cluster.enums;

import io.openems.edge.battery.soltaro.cluster.SoltaroCluster;

/*
 *  Helper class to get infos about connected racks
 */
public enum RackInfo {
	RACK_1(1, 0x2000, SoltaroCluster.ChannelId.RACK_1_USAGE, SoltaroCluster.ChannelId.RACK_1_POSITIVE_CONTACTOR,
			SoltaroCluster.ChannelId.SUB_MASTER_1_COMMUNICATION_FAILURE), //
	RACK_2(2, 0x3000, SoltaroCluster.ChannelId.RACK_2_USAGE, SoltaroCluster.ChannelId.RACK_2_POSITIVE_CONTACTOR,
			SoltaroCluster.ChannelId.SUB_MASTER_2_COMMUNICATION_FAILURE), //
	RACK_3(3, 0x4000, SoltaroCluster.ChannelId.RACK_3_USAGE, SoltaroCluster.ChannelId.RACK_3_POSITIVE_CONTACTOR,
			SoltaroCluster.ChannelId.SUB_MASTER_3_COMMUNICATION_FAILURE), //
	RACK_4(4, 0x5000, SoltaroCluster.ChannelId.RACK_4_USAGE, SoltaroCluster.ChannelId.RACK_4_POSITIVE_CONTACTOR,
			SoltaroCluster.ChannelId.SUB_MASTER_4_COMMUNICATION_FAILURE), //
	RACK_5(5, 0x6000, SoltaroCluster.ChannelId.RACK_5_USAGE, SoltaroCluster.ChannelId.RACK_5_POSITIVE_CONTACTOR,
			SoltaroCluster.ChannelId.SUB_MASTER_5_COMMUNICATION_FAILURE);

	/**
	 * Get the {@link RackInfo} for the given ID
	 * 
	 * @param rackId from 1 to 5
	 * @return the RackInfo
	 */
	public static RackInfo getRack(int rackId) {
		for (RackInfo rackInfo : RackInfo.values()) {
			if (rackId == rackInfo.id) {
				return rackInfo;
			}
		}
		throw new IllegalArgumentException("Rack with ID [" + rackId + "] is not available!");
	}

	public final int id;
	public final int offset;
	public final SoltaroCluster.ChannelId usageChannelId;
	public final SoltaroCluster.ChannelId positiveContactorChannelId;
	public final SoltaroCluster.ChannelId subMasterCommunicationAlarmChannelId;

	private RackInfo( //
			int id, //
			int addressOffset, //
			SoltaroCluster.ChannelId usageChannelId, //
			SoltaroCluster.ChannelId positiveContactorChannelId, //
			SoltaroCluster.ChannelId subMasterCommunicationAlarmChannelId //
	) {
		this.id = id;
		this.offset = addressOffset;
		this.usageChannelId = usageChannelId;
		this.subMasterCommunicationAlarmChannelId = subMasterCommunicationAlarmChannelId;
		this.positiveContactorChannelId = positiveContactorChannelId;
	}

	/**
	 * Gets the Channel-ID Prefix for this Rack in the form "RACK_<ID>_".
	 * 
	 * @return the prefix
	 */
	public String getChannelIdPrefix() {
		return "RACK_" + this.id + "_";
	}

}