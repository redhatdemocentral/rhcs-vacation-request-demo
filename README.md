App Dev Cloud with JBoss Vacation Request Demo
==============================================
This demo is to install JBoss BPM Suite based vacation request application in the Cloud based on leveraging the OpenShift Container Platform (OCP). It delivers a fully functioning HR employee vacation request example containerized on OCP.

This is a simple vacation request process project for employees to request PTO / Vacation days. It demonstrates the following
functionality:

- Rest service (GET & POST)

- Human Task assignment and escalation

- Business Rule for auto approval

This is a vacation process example which calls out to a REST service to get vacation information based on a particular ID.  Based on the rule for hours requested (10 hours or less), the request is auto approved or is routed to a manager.  If the manager does not claim/complete the task in 30 seconds, it's escalated to another group.  Once approved or not approved, the original requester can see the status.


Install on OpenShift (OCP)
--------------------------
1. First ensure you have an OpenShift container based installation, such as one of the followling installed first:

    - [OCP Install Demo](https://github.com/redhatdemocentral/ocp-install-demo)

    - or your own OpenShift installation.

2. [Download and unzip this demo.](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/archive/master.zip)

3. Download JBoss EAP & JBoss BPM Suite, add to installs directory (see installs/README).

4. Run 'init.sh' or 'init.bat' file. 'init.bat' must be run with Administrative privileges.

Log in to JBoss BPM Suite to start exploring a generic loan application (the address will be generated by the init
script):

  - OCP example: http://rhcs-vacation-demo-appdev-in-cloud.192.168.99.100.nip.io/business-central ( u:erics / p:bpmsuite1! )


Notes
-----
This project can be installed on any OpenShift platform, such as OpenShift Container Platform.
It's possible to install it on any available installation by pointing this installer to an OpenShift IP address:

```
  $ ./init.sh IP
```

-----

If for any reason the installation breaks or you want a new JBoss BRMS installation, just remove the project rhcs-bpms-install-demo
entry in the OpenShift console and re-run the installation.

-----


Submitting a Vacation Request
-----------------------------
1. Fill in the ID number associated with the user

2. Fill in the number of hours being requested

3. If it's less than 10, it will be auto approved and the user will be assigned the task to see the approval

4. If it's more than 10, it will be routed to the manager

5. If user erics does not claim/complete the task within 30 seconds, it is routed back into the `manager` group

6. Check the box to approve or not approve the vacation request

The REST Service API can be queried to show:

- Get a list of all users -> [GET] http://localhost:8080/vacation/rest/

- Get specific user -> [GET] http://localhost:8080/vacation/rest/1

- Get the hours for a specific user -> [GET] http://localhost:8080/vacation/rest/hours/1

- Submit a vacation request --> [POST] http://localhost:8080/vacation/rest/request   

  [DATA] `{"associateId":"1","hours":-300}`

-----


Supporting Articles
-------------------
- [How to Optimize Existing IT by Modernizing HR Processes](http://www.schabell.org/2017/07/how-to-optimize-existing-it-modernizing-hr-processes.html)

- [3 Ways to Empower Employee Vacation Request Process](http://www.schabell.org/2016/05/3-ways-empower-employee-vacation-request-process.html)


Released versions
-----------------
See the tagged releases for the following versions of the product:

- v1.4 - JBoss BPM Suite 6.4.0 and JBoss EAP 7.0.0 with OpenShift genereated routes and service URLs.

- v1.3 - JBoss BPM Suite 6.4.0 and JBoss EAP 7.0.0 with vacation request process installed on any given OpenShift installation and loading mulitple projects.

- v1.2 - JBoss BPM Suite 6.3.0 and JBoss EAP 6.4.7 with vacation request installed on Red Hat CDK.

- v1.1 - JBoss BPM Suite 6.2.0-BZ-1299002 on JBoss EAP 6.4.4 with vacation request installed on Red Hat CDK.

- v1.0 - JBoss BPM Suite 6.2.0-BZ-1299002 on JBoss EAP 6.4.4 with vacation request installed on Red Hat CDK using OpenShift Enterprise image.

![BPM Suite](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/blob/master/docs/demo-images/bpmsuite.png?raw=true)

![Vacation Process](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/blob/master/docs/demo-images/process.png?raw=true)

![Cloud Suite](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/blob/master/docs/demo-images/rhcs-arch.png?raw=true)

