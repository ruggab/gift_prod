package net.mcsistemi.storeops.repository;

import net.mcsistemi.storeops.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public interface GiftCardRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from check_gift_availability(?1, ?2)", nativeQuery = true)
    ICheckGiftAvailability check_gift_availability(String idstore, String gnumber);

    @Query(value = "select * from gift_activation(?1, ?2, ?3, ?4)", nativeQuery = true)
    IGiftActivation gift_activation(String idstore, String gnumber, Double gamount, String codrec);

    @Query(value = "select * from gift_check_value(?1, ?2)" , nativeQuery = true)
    ICheckGiftValue gift_check_value(String idstore, String gnumber);

    @Query(value = "select * from gift_movement(?1, ?2, ?3, ?4)" , nativeQuery = true)
    IGiftMovement gift_movement(String idstore, String gnumber, Double gamount, String codrec);

    @Query(value = "select * from coupon_activation(?1, ?2, ?3)" , nativeQuery = true)
    ICouponActivation coupon_activation(String idstore, Double gamount, String codrec);

    @Query(value = "select gift_number, expiration_date, sum(current_amount) as saldo from gift_movements\n" +
            "where gift_number = ?1\n" +
            "group by gift_number, expiration_date" , nativeQuery = true)
    IGiftCheckView gift_check_view(String gnumber);

    @Query(value = "SELECT public.gift_generate_newcode( ?1 ) ; ", nativeQuery = true)
    String gift_generate_newcode(String idstore);

    @Query(value = "SELECT 1 ; ", nativeQuery = true)
    Integer checkDbConn();

    @Query(value = "select description from gift_status ;" , nativeQuery = true)
    List<String> getAllGiftStatus();

    @Query(value = "select id_client,description from departments where id_customer = 37 and active = true ;" , nativeQuery = true)
    List<INegozi> getAllNegozi();

    @Query(value = "SELECT id_client, gift_number, description, issue_date, expiration_date, initial_amount, current_amount, status_description, type\n" +
            "FROM public.gift_current_status AS g where ( ?1 = '' OR g.id_client = ?1) AND g.issue_date >= ?2 AND g.issue_date <= ?3 \n" +
            "AND ( ?4 = '' OR g.status_description = ?4) AND ( ?5 = '' OR g.type = ?5) ; " , nativeQuery = true)
    List<IGiftDetails> getAllGiftByCustomFilter(String idClient, Date fromDate, Date toDate, String statusDesc, String type);

    @Query(value = "SELECT * FROM public.gift_current_status where gift_number LIKE ?1% ;" , nativeQuery = true)
    List<IGiftDetails> getDetailsByGiftNumber(String gnumber);

    @Query(value = "SELECT gm.*,dp.description FROM gift_movements gm\n" +
            "JOIN departments dp ON dp.id_client = gm.id_client\n" +
            "WHERE gm.gift_number = ?1 ;" , nativeQuery = true)
    List<IGiftMovementsDetails> getGiftMovementsDetailsByGnumber(String gnumber);

    @Query(value = "SELECT * FROM public.gift_da_attivare WHERE id_client = ?1 ; " , nativeQuery = true)
    List<IGiftDaAttivare> getGiftDaAttivare(String id_client);

    @Query(value = "SELECT code FROM public.gift_languages ; " , nativeQuery = true)
    List<String> getLanguages();

    @Query(value = "SELECT * from generate_gift( ?1 , ?2 ) ; " , nativeQuery = true)
    IGenerateGiftResponse generateGift(Integer gift_qta, String gift_language);

    @Query(value = "SELECT doc.id doc_number, doc.date, gl.name \"language\", count (dd.epc) qta FROM documents doc \n" +
            "JOIN documents_detail dd ON doc.id=dd.id_document\n" +
            "JOIN gift_languages gl ON gl.code=split_part(doc.ref,'_',2)\n" +
            "WHERE doc.id_client='2-100000' AND doc.type=1873 AND doc.reason=1874\n" +
            "GROUP BY doc.id, doc.date, gl.name,doc.timestamp\n" +
            "ORDER BY doc.timestamp DESC ; " , nativeQuery = true)
    List<IGiftDocument> getDocuments();

    @Query(value = "SELECT row_number() over() n_riga,id_document,package_no, epc FROM documents_detail \n" +
            "WHERE id_document= ?1 \n" +
            "ORDER BY id_line ; " , nativeQuery = true)
    List<IGiftDocumentDetails> getDocumentDetails(Long id_document);

    @Query(value = "SELECT * FROM public.gift_to_assign ; " , nativeQuery = true)
    List<IGiftToAssign> getGiftToAssign();

    @Query(value = "SELECT * FROM public.assign_gift( ?1 , ?2 ) ; " , nativeQuery = true)
    String assignGift(String package_no, String idstore);

    @Modifying
    @Query(value = "UPDATE public.gift_settings SET lot_size = ?1 WHERE id = 1 ; " , nativeQuery = true)
    void updateLotSize(Long lot_size);

    @Query(value = "SELECT lot_size FROM public.gift_settings ; " , nativeQuery = true)
    Long getLotSize();

    @Query(value = "SELECT card, url, package_no, lang FROM public.export_gift_to_print WHERE id_document = ?1 ;" , nativeQuery = true)
    List<IExportGift> getGiftToExport(Long id_document);

    @Query(value = "SELECT * FROM public.dashboard_graf(?1 , ?2) ; " , nativeQuery = true)
    List<IHistogramGraph> getHistogram(String year, String month);

    @Query(value = "SELECT * FROM public.dashboard_value( ?1 , ?2 ) ; " , nativeQuery = true)
    List<IGrafici> getGrafici(String year, String month);


}
