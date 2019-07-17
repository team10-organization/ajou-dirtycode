package ac.kr.ajou.dirt2;

import java.util.HashSet;
import java.util.Set;

public class IpAddressMacAddress {

    // single ip, single mac, accountId, ip + mac
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {
        Set<String> combinedIdentification = new HashSet<>();
        buildForSingleIp(pbe, combinedIdentification);
        // single mac
        buildForSingleMac(pbe, combinedIdentification);
        // accountId
        buildForAccountId(pbe, combinedIdentification);
        // ip + mac
        buildForIpAndMac(pbe, combinedIdentification);
        return combinedIdentification;
    }

    private void buildForIpAndMac(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (isValidMac(pbe.getMac())) {
            if (pbe.getIp() != null && !pbe.getIp().isEmpty()) {
                String[] macAddresses = pbe.getMac().split(",");
                if (macAddresses.length <= 100) {
                    for (int i = 0; i < macAddresses.length; i++) {
                        combinedIdentification.add(pbe.getIp() + macAddresses[i]);
                    }
                }
            }
        }
    }

    private void buildForAccountId(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (isValidAccountId(pbe.getAccountId())) {
            if (!pbe.getAccountId().equals("0")) {
                combinedIdentification.add(pbe.getAccountId());
            } else {
                System.out.println("Account id can't be 0");
            }
        }
        System.out.println("Account is is null or empty");

    }

    private boolean isValidAccountId(String accountId) {
        return accountId != null && !accountId.isEmpty();
    }

    private void buildForSingleMac(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (isValidMac(pbe.getMac())) {
            String[] macAddresses = pbe.getMac().split(",");
            if (macAddresses.length <= 100) {
                for (int i = 0; i < macAddresses.length; i++) {
                    combinedIdentification.add(macAddresses[i]);
                }
            } else {
                logErrorMessage("Mac address too many");
            }
        }
        logErrorMessage("Mac address is wrong");
    }

    private void logErrorMessage(String s) {
        System.out.println(s);
    }

    private boolean isValidMac(String mac) {
        return mac != null && !mac.isEmpty();
    }

    private void buildForSingleIp(PcBangEvent pbe, Set<String> combinedIdentification) {
        // single IP
        if (pbe.getIp() != null) {
            combinedIdentification.add(pbe.getIp());
        }
    }
}
