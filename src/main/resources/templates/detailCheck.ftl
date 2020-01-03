<?xml version="1.0" encoding="UTF-8"?>
<Document xmlns="urn:cnaps:std:hvps:2010:tech:xsd:hvps.712.001.01">
    <DtlReq>
        <DtlReqInf>
            <ChckngDt>${date}</ChckngDt>
            <#list detailList as list>
                <Dtls>
                <MT>${list.MT}</MT>
                <TxTpCd>${list.TxTpCd}</TxTpCd>
                </Dtls>
            </#list>
        </DtlReqInf>
    </DtlReq>
</Document>