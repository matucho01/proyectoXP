package ec.edu.epn;

public class TurnosOctubre {
    private String lecturas;

    public TurnosOctubre() {
        this.lecturas = "02-10-22,443196.34,286690.74,371706.48,443207.39,287192.01,372008.05,0\n" +
                "02-10-22,443207.39,287192.01,372008.05,443236.04,287704.88,372333.19,1\n" +
                "02-10-22,443236.04,287704.88,372333.19,443260.49,288799.46,372845.79,2\n" +
                "03-10-22,443260.49,288799.46,372845.79,443274.08,289499.98,373415.45,0\n" +
                "03-10-22,443274.08,289499.98,373415.45,443289.82,289858.54,373915.45,1\n" +
                "03-10-22,443289.82,289858.54,373915.45,443301.27,290901.01,374554.77,2\n" +
                "04-10-22,443301.27,290901.01,374554.77,443324.24,291650.17,374842.57,0\n" +
                "04-10-22,443324.24,291650.17,374842.57,443344.24,292350.17,375144.31,1\n" +
                "04-10-22,443344.24,292350.17,375144.31,443370.19,293148.49,375418.18,2\n" +
                "05-10-22,443370.19,293148.49,375418.18,443389.05,293834.59,376107.35,0\n" +
                "05-10-22,443389.05,293834.59,376107.35,443417.05,294534.59,376708.09,1\n" +
                "05-10-22,443417.05,294534.59,376708.09,443426.76,295206.80,377485.68,2\n" +
                "06-10-22,443426.76,295206.80,377485.68,443446.87,295957.83,377928.27,0\n" +
                "06-10-22,443446.87,295957.83,377928.27,443467.32,296659.28,378370.85,1\n" +
                "06-10-22,443467.32,296659.28,378370.85,443487.10,297459.88,378813.44,2\n" +
                "07-10-22,443487.10,297459.88,378813.44,443508.90,298313.91,379242.70,0\n" +
                "07-10-22,443508.90,298313.91,379242.70,443535.64,299063.07,379597.57,1\n" +
                "07-10-22,443535.64,299063.07,379597.57,443552.51,300021.96,380101.21,2\n" +
                "08-10-22,443552.51,300021.96,380101.21,443587.90,300919.09,380442.09,0\n" +
                "08-10-22,443587.90,300919.09,380442.09,443613.77,301668.25,380821.86,1\n" +
                "08-10-22,443613.77,301668.25,380821.86,443658.69,302713.35,381123.84,2\n" +
                "09-10-22,443658.69,302713.35,381123.84,443676.62,303527.26,381488.59,0\n" +
                "09-10-22,443676.62,303527.26,381488.59,443699.40,304276.42,381868.36,1\n" +
                "09-10-22,443699.40,304276.42,381868.36,443712.47,305155.08,382218.09,2\n" +
                "10-10-22,443712.47,305155.08,382218.09,443734.85,305861.73,382550.72,0\n" +
                "10-10-22,443734.85,305861.73,382550.72,443754.85,306610.89,382930.49,1\n" +
                "10-10-22,443754.85,306610.89,382930.49,443779.61,307275.04,383215.99,2\n" +
                "11-10-22,443779.61,307275.04,383215.99,443793.10,307997.25,383713.60,0\n" +
                "11-10-22,443793.10,307997.25,383713.60,443815.10,308746.41,384093.37,1\n" +
                "11-10-22,443815.10,308746.41,384093.37,443820.08,309441.68,384708.83,2\n" +
                "12-10-22,443820.08,309441.68,384708.83,443847.72,310121.30,385157.37,0\n" +
                "12-10-22,443847.72,310121.30,385157.37,443885.72,310842.20,385539.47,1\n" +
                "12-10-22,443885.72,310842.20,385539.47,443902.99,311480.54,386054.46,2\n" +
                "13-10-22,443902.99,311480.54,386054.46,443914.34,312247.11,386458.73,0\n" +
                "13-10-22,443914.34,312247.11,386458.73,443924.84,312889.98,386747.93,1\n" +
                "13-10-22,443924.84,312889.98,386747.93,443937.04,313780.26,387267.26,2\n" +
                "14-10-22,443937.04,313780.26,387267.26,443955.58,314581.61,387847.50,0\n" +
                "14-10-22,443955.58,314581.61,387847.50,443972.70,315280.81,388173.39,1\n" +
                "14-10-22,443972.70,315280.81,388173.39,443992.67,316184.32,389007.97,2\n" +
                "15-10-22,443992.67,316184.32,389007.97,444013.31,316886.28,389363.60,0\n" +
                "15-10-22,444013.31,316886.28,389363.60,444032.56,317617.86,389685.82,1\n" +
                "15-10-22,444032.56,317617.86,389685.82,444054.60,318290.19,390074.86,2\n" +
                "16-10-22,444054.60,318290.19,390074.86,444082.36,318891.07,390430.38,0\n" +
                "16-10-22,444082.36,318891.07,390430.38,444110.81,319653.37,390755.52,1\n" +
                "16-10-22,444110.81,319653.37,390755.52,444137.87,320092.83,391141.42,2\n" +
                "17-10-22,444137.87,320092.83,391141.42,444158.41,320853.96,391490.63,0\n" +
                "17-10-22,444158.41,320853.96,391490.63,444171.20,321721.16,391805.61,1\n" +
                "17-10-22,444171.20,321721.16,391805.61,444199.49,322376.22,392189.05,2\n" +
                "18-10-22,444199.49,322376.22,392189.05,444227.17,323095.07,392638.72,0\n" +
                "18-10-22,444227.17,323095.07,392638.72,444256.33,323778.54,393012.94,1\n" +
                "18-10-22,444256.33,323778.54,393012.94,444282.54,324532.77,393538.05,2\n" +
                "19-10-22,444282.54,324532.77,393538.05,444290.62,325238.79,393835.05,0\n" +
                "19-10-22,444290.62,325238.79,393835.05,444299.58,326051.06,394161.02,1\n" +
                "19-10-22,444299.58,326051.06,394161.02,444306.78,326650.83,394429.05,2\n" +
                "20-10-22,444306.78,326650.83,394429.05,444317.04,327407.74,394800.05,0\n" +
                "20-10-22,444317.04,327407.74,394800.05,444329.33,327929.67,395189.19,1\n" +
                "20-10-22,444329.33,327929.67,395189.19,444337.57,328921.55,395542.05,2\n" +
                "21-10-22,444337.57,328921.55,395542.05,444365.44,329748.77,395901.00,0\n" +
                "21-10-22,444365.44,329748.77,395901.00,444402.09,330498.01,396259.19,1\n" +
                "21-10-22,444402.09,330498.01,396259.19,444421.19,331403.21,396618.91,2\n" +
                "22-10-22,444421.19,331403.21,396618.91,444438.27,332250.95,396979.29,0\n" +
                "22-10-22,444438.27,332250.95,396979.29,444456.12,332882.84,397377.89,1\n" +
                "22-10-22,444456.12,332882.84,397377.89,444472.43,333946.42,397700.05,2\n" +
                "23-10-22,444472.43,333946.42,397700.05,444486.43,334545.82,398026.38,0\n" +
                "23-10-22,444486.43,334545.82,398026.38,444500.98,335367.72,398337.28,1\n" +
                "23-10-22,444500.98,335367.72,398337.28,444514.42,335744.63,398679.05,2\n" +
                "24-10-22,444514.42,335744.63,398679.05,444532.80,336497.28,399073.57,0\n" +
                "24-10-22,444532.80,336497.28,399073.57,444545.21,337238.51,399469.67,1\n" +
                "24-10-22,444545.21,337238.51,399469.67,444569.57,338002.59,399862.60,2\n" +
                "25-10-22,444569.57,338002.59,399862.60,444608.07,338730.28,400215.61,0\n" +
                "25-10-22,444608.07,338730.28,400215.61,444657.24,339528.50,400612.25,1\n" +
                "25-10-22,444657.24,339528.50,400612.25,444685.08,340185.65,400921.63,2\n" +
                "26-10-22,444685.08,340185.65,400921.63,444717.37,340904.73,401325.49,0\n" +
                "26-10-22,444717.37,340904.73,401325.49,444750.35,341536.87,401693.61,1\n" +
                "26-10-22,444750.35,341536.87,401693.61,444781.94,342342.89,402133.22,2\n" +
                "27-10-22,444781.94,342342.89,402133.22,444812.32,343134.32,402434.50,0\n" +
                "27-10-22,444812.32,343134.32,402434.50,444849.52,343866.82,402823.64,1\n" +
                "27-10-22,444849.52,343866.82,402823.64,444873.08,344717.18,403037.07,2\n" +
                "28-10-22,444873.08,344717.18,403037.07,444903.92,345507.72,403372.40,0\n" +
                "28-10-22,444903.92,345507.72,403372.40,444932.08,346422.05,403838.61,1\n" +
                "28-10-22,444932.08,346422.05,403838.61,444965.60,347088.81,404043.07,2\n" +
                "29-10-22,444965.60,347088.81,404043.07,444975.18,348020.39,404330.40,0\n" +
                "29-10-22,444975.18,348020.39,404330.40,444984.68,348763.71,404808.63,1\n" +
                "29-10-22,444984.68,348763.71,404808.63,444994.34,349883.56,404905.07,2\n" +
                "30-10-22,444994.34,349883.56,404905.07,445022.16,350508.19,405125.07,0\n" +
                "30-10-22,445022.16,350508.19,405125.07,445098.28,351237.79,405423.43,1\n" +
                "30-10-22,445098.28,351237.79,405423.43,445077.81,351757.46,405565.07,2\n" +
                "31-10-22,445077.81,351757.46,405565.07,445105.04,352369.34,405878.07,0\n" +
                "31-10-22,445105.04,352369.34,405878.07,445134.51,353118.50,406257.84,1\n" +
                "31-10-22,445134.51,353118.50,406257.84,445159.50,353593.10,406504.07,2\n" +
                "01-11-22,445159.50,353593.10,406504.07,445201.67,354318.99,406884.65,0\n";
    }

    public String getLecturas() {
        return this.lecturas;
    }
}
