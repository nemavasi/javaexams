package javaexams.exceptions;

public class TstTryFinally {
  public static void main(String[] args) {

    System.out.println("{\"records\": [{\"mode\": \"update\",\"primaryKeyValue\": 117,\"fields\": [{\"fieldId\": \"id\",\"value\": \"117\"},{\"fieldId\": \"request_id\",\"value\": 62},{\"fieldId\": \"service_csm_id\",\"value\": 135},{\"fieldId\": \"station_type_id\",\"value\": 1},{\"fieldId\": \"status_id\",\"value\": 1},{\"fieldId\": \"station_id1\",\"value\": 20006142},{\"fieldId\": \"station_id2\",\"value\": 20006141},{\"fieldId\": \"service_date\",\"value\": \"\"},{\"fieldId\": \"service_date_locale\",\"value\": \"2020-10-30T17:04:00\"},{\"fieldId\": \"train_number\",\"value\": \"\"},{\"fieldId\": \"vagon_number\",\"value\": \"\"},{\"fieldId\": \"seats_number\",\"value\": \"\"},{\"fieldId\": \"car_carrier_group_id\",\"value\": null},{\"fieldId\": \"meeting_point_id\",\"value\": \"\"},{\"fieldId\": \"service_nohelp\",\"value\": false},{\"fieldId\": \"service_wheelchair\",\"value\": true},{\"fieldId\": \"service_escort_help\",\"value\": false},{\"fieldId\": \"service_boarding_help\",\"value\": false},{\"fieldId\": \"service_baggage_help\",\"value\": false},{\"fieldId\": \"service_commentary\",\"value\": \"\"},{\"fieldId\": \"baggage_cnt\",\"value\": null},{\"fieldId\": \"baggage_weight\",\"value\": null},{\"fieldId\": \"in_group\",\"value\": false},{\"fieldId\": \"in_group_disabled_cnt\",\"value\": \"\"},{\"fieldId\": \"service_able_to_board\",\"value\": false}]},{\"mode\": \"update\",\"primaryKeyValue\": ,\"fields\": [{\"fieldId\": \"id\",\"value\": \"\"},{\"fieldId\": \"request_id\",\"value\": 62},{\"fieldId\": \"service_csm_id\",\"value\": 136},{\"fieldId\": \"station_type_id\",\"value\": 2},{\"fieldId\": \"status_id\",\"value\": 1},{\"fieldId\": \"station_id1\",\"value\": 20006141},{\"fieldId\": \"station_id2\",\"value\": 20006142},{\"fieldId\": \"service_date\",\"value\": \"\"},{\"fieldId\": \"service_date_locale\",\"value\": \"2020-10-30T17:06:00\"},{\"fieldId\": \"train_number\",\"value\": \"\"},{\"fieldId\": \"vagon_number\",\"value\": \"\"},{\"fieldId\": \"seats_number\",\"value\": \"\"},{\"fieldId\": \"car_carrier_group_id\",\"value\": null},{\"fieldId\": \"meeting_point_id\",\"value\": \"\"},{\"fieldId\": \"service_nohelp\",\"value\": false},{\"fieldId\": \"service_wheelchair\",\"value\": true},{\"fieldId\": \"service_escort_help\",\"value\": false},{\"fieldId\": \"service_boarding_help\",\"value\": false},{\"fieldId\": \"service_baggage_help\",\"value\": false},{\"fieldId\": \"service_commentary\",\"value\": \"\"},{\"fieldId\": \"baggage_cnt\",\"value\": null},{\"fieldId\": \"baggage_weight\",\"value\": null},{\"fieldId\": \"in_group\",\"value\": false},{\"fieldId\": \"in_group_disabled_cnt\",\"value\": \"\"},{\"fieldId\": \"service_able_to_board\",\"value\": false}]}]}");

    try {
      throw new StackOverflowError();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } catch (Throwable e) {
      throw new RuntimeException(e);
    } finally {
      System.out.println("asdas");
    }



  }
}
