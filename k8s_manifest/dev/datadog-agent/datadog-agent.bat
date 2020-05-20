kubectl apply -f clusterrole.yaml
kubectl apply -f serviceaccount.yaml
kubectl apply -f clusterrolebinding.yaml

kubectl apply -f namespace.yaml
kubectl config set-context --current --namespace=datadog-apm-sample

kubectl create secret generic datadog-secret --from-literal=api-key="d1fdceb9fa95b88cc1cc38f2186a10d7"
kubectl get secret datadog-secret -o yaml 

kubectl apply -f datadog-agent.yaml