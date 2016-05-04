App Dev Cloud with JBoss Vacation Request Demo
==============================================
This demo is to install JBoss BPM Suite Vacation Request Demo in the Cloud based on leveraging the Red Hat 
Container Development Kit (CDK) and the provided OpenShift Enterprise (OSE) image. 
It delivers a fully functioning JBoss BPM Vacation Request example containerized on OSE.

This is a simple vacation request process project for employees to request PTO / Vacation days. It demonstrates the following
functionality:

- Rest service (GET & POST)

- Human Task assignment and escalation

- Business Rule for auto approval

This is a vacation process example which calls out to a REST service to get vacation information based on a particular ID.  Based on the rule for hours requested (10 hours or less), the request is auto approved or is routed to a manager.  If the manager does not claim/complete the task in 30 seconds, it's escalated to another group.  Once approved or not approved, the original requester can see the status.


Install on Red Hat CDK OpenShift Enterprise image
-------------------------------------------------
1. First complete the installation and start the OpenShift image supplied in the
	 [cdk-install-demo](https://github.com/redhatdemocentral/cdk-install-demo).

2. Install [OpenShift Client Tools](https://developers.openshift.com/managing-your-applications/client-tools.html) if you have not
	 done so previously.

2. [Download and unzip this demo.](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/archive/master.zip)

3. Add products to installs directory.

5. Run 'init.sh' or 'init.bat' file. 'init.bat' must be run with Administrative privileges.

6. Login to start exploring a vacation request project:

    [http://rhcs-vacation-demo.10.1.2.2.xip.io/business-central](http://rhcs-vacation-demo.10.1.2.2.xip.io/business-central)
    ( u:erics / p:rhcsuite1! )



Notes
-----
Should your local network DNS not handle the resolution of the above address, giving you page not found errors, you can apply the
following to your local hosts file:

```
$ sudo vi /etc/hosts

# add host for CDK demo resolution.
10.1.2.2   rhcs-vacation-demo.10.1.2.2.xip.io    rhcs-vacation-demo.10.1.2.2.xip.io
```


Submitting a Vacation Request
-----------------------------
1. Fill in the ID number associated with the user

2. Fill in the number of hours being requested

3. If it's less than 10, it will be auto approved and the user will be assigned the task to see the approval

4. If it's more than 10, it will be routed to the manager

5. If the manager does not claim/complete the task within 30 seconds, it is routed to `joe`

6. Check the box to approve or not approve the vacation request

The REST Service API can be queried to show:

- Get a list of all users -> [GET] http://localhost:8080/vacation/rest/

- Get specific user -> [GET] http://localhost:8080/vacation/rest/1

- Get the hours for a specific user -> [GET] http://localhost:8080/vacation/rest/hours/1

- Submit a vacation request --> [POST] http://localhost:8080/vacation/rest/request   

  [DATA] `{"associateId":"1","hours":-300}`


Supporting Articles
-------------------
coming soon...


Released versions
-----------------
See the tagged releases for the following versions of the product:

- v1.0 - JBoss BPM Suite 6.2.0-BZ-1299002 on JBoss EAP 6.4.4 with vacation request installed on Red Hat CDK using OpenShift Enterprise image.

![BPM Suite](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/blob/master/docs/demo-images/bpmsuite.png?raw=true)

![Vacation Process](https://github.com/redhatdemocentral/rhcs-vacation-request-demo/blob/master/docs/demo-images/process.png?raw=true)


