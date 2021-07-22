public class Record {
    String processName;
    int processId;
    String user;
    int cpu;
    int bytesOfMemeory;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getBytesOfMemeory() {
        return bytesOfMemeory;
    }

    public void setBytesOfMemeory(int bytesOfMemeory) {
        this.bytesOfMemeory = bytesOfMemeory;
    }


    @Override
    public String toString() {
        return "Record{" +
                "processName='" + processName + '\'' +
                ", processId=" + processId +
                ", user='" + user + '\'' +
                ", cpu=" + cpu +
                ", bytesOfMemeory=" + bytesOfMemeory +
                '}';
    }
}
