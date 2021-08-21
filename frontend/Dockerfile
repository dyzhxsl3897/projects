FROM node:lts-alpine as BUILD
COPY package*.json /
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.21.1-alpine
COPY --from=BUILD /dist /usr/share/nginx/html