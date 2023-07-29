package entity;

public class Properties {
    private Integer id;
    private boolean admin_role;
    private boolean owner_role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(boolean admin_role) {
        this.admin_role = admin_role;
    }

    public boolean isOwner_role() {
        return owner_role;
    }

    public void setOwner_role(boolean owner_role) {
        this.owner_role = owner_role;
    }


}
